import './SignInPage.css'
import CircularProgress from '@mui/material/CircularProgress';
import { useState } from 'react';
import UserUtlis from '../utils/UserUtils.js'
import TextField from '@mui/material/TextField';
import { FormControl, Button } from '@mui/material';
import { useNavigate } from "react-router-dom";
import SimpleAlert from './reusable/SimpleAlert';
import { setAccessToken, toggleLogin } from '../store/loginSlice';
import { useDispatch } from 'react-redux';

const SignInPage = () => {

    const navigate = useNavigate();

    const dispatch = useDispatch()

    //Alert control
    const [open, setOpen] = useState(false);
    const [alertInfo, setAlertInfo] = useState({
        title: "",
        content: ""
    })

    const handleClickOpen = () => {
      setOpen(true);
    };
  
    const handleClose = () => {
      setOpen(false);
    };

    // Visiability of loading screen control
    const blockerDisplayOption = {
        visable: {
            display: "flex"
        },
        hidden:  {
            display: "none"
        }
    }
    const [isBlockerOut, setIsBLockerOut] = useState(blockerDisplayOption.hidden)

    // textfields styles
    const styleForTextFields = { width: "20vw" }

    // text field control
    const [formValues, setFormValues] = useState({
        login: "",
        password: "",
    });

    const registrationSettled = (response) => {
        console.log("Logowanie powidło się")
        if( response.status === 200 ){
            dispatch(toggleLogin (formValues.login))
            let token = JSON.stringify(response.data.acces_token)
            localStorage.setItem("access_token", token)
            dispatch(setAccessToken(response.data.acces_token))
            navigate("/access/dashboard");
        } else registrationRejected()
    }

    const registrationRejected = () => {
        console.log("Logowanie nie powidło się")
        setAlertInfo({
            title: "Logowanie nie powiodło się",
            content: ""
        })
        handleClickOpen();
    }

    const handleInputChange = (e) => {
            const { name, value } = e.target;
            setFormValues({
            ...formValues,
            [name]: value,
            });
        };

    const LogIn = async () => {
        setIsBLockerOut(blockerDisplayOption.visable)

        await UserUtlis.requestLogIn(
            { login: formValues.login, password: formValues.password },
            registrationSettled,
            registrationRejected,
        )

        setIsBLockerOut(blockerDisplayOption.hidden)
    }

    return (
        <div>
            <div className='formBox'>
                <FormControl>
                    <TextField
                        required
                        id="login"
                        name="login"
                        label="Login"
                        sx={styleForTextFields}
                        margin="normal"
                        value={formValues.login}
                        onChange={handleInputChange}
                        />
                    <TextField
                        required
                        id="password"
                        name="password"
                        label="Password"
                        sx={styleForTextFields}
                        margin="normal"
                        value={formValues.password}
                        onChange={handleInputChange}
                        />

                    <div className='formControlButtons'>
                        <Button 
                            variant="contained" 
                            color="primary" 
                            type="submit" 
                            sx={{backgroundColor: "#C1FCF5", color: "black"}} 
                            onClick={() => LogIn()}>
                            Log In
                        </Button>
                    </div>
                </FormControl>
            <div className='loadingBlocker' style={isBlockerOut}>
                <CircularProgress />
            </div>
        </div>
            <SimpleAlert
                open={open}
                onClose={handleClose}
                info={alertInfo}
            />
    </div>
    );
}

export default SignInPage;