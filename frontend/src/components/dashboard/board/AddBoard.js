import './AddBoard.css'
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import { useState } from 'react';

const AddBoard = () => {

  const [selectedOptions, setSelectedOptions] = useState([]);

  const top100Films = [
    { title: 'The Shawshank Redemption', year: 1994 },
    { title: 'The Godfather', year: 1972 },
    { title: 'The Godfather: Part II', year: 1974 },
    { title: 'The Dark Knight', year: 2008 },
    { title: '12 Angry Men', year: 1957 },
    { title: "Schindler's List", year: 1993 },
    { title: 'Pulp Fiction', year: 1994 }
  ]

  return (
    <div className='addFormBox'>
      <form>
        <label for="login">Name:</label><br/>
        <input type="text" id="login" name="login"/><br/>

        <label for="cemail">Collabolators:</label><br/>
        <Autocomplete
          disableClearable
          multiple
          id="multiple-limit-tags"
          onChange={(event, newValue) => {
            setSelectedOptions(newValue);
          }}
          isOptionEqualToValue={(option, value) => option.title === value.title}
          options={top100Films}
          getOptionLabel={(option) => option.title}
          renderInput={(params) => (
            <TextField {...params} variant="standard" sc={{ paddingLeft: '5vw' }} />
          )}
          sx={{ width: '20vw', marginBottom: '10px' }}
        />

        <label for="password">Password:</label><br/>
        <input type="password" id="password" name="password"/><br/>

        <label for="cpassword">Confirm password:</label><br/>
        <input type="password" id="cpassword" name="cpassword"/><br/>

        <div>
          <button>
            Submit
          </button>
          <input type="reset" value="Reset"/>
        </div>
      </form>
    </div>
  );
}

export default AddBoard;