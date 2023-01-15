import * as React from 'react';
import Button from '@mui/material/Button';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import { Autocomplete } from '@mui/material';
import { useSelector } from 'react-redux';
import Tags from '../../enums/Tags';
import { useState } from 'react';
import TextField from '@mui/material/TextField';

const EditBoardDialog = (props) => {

  const board = useSelector(state => state.board)

  // text field control
  const [formValues, setFormValues] = useState({
    id: 1,
    title: "",
    description: "",
    tag: ""
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormValues({
    ...formValues,
    [name]: value,
    });
  };

  const styleForTextFields = { width: "20vw" }
  const { onClose, open, SendDataFunction, deleteFunction } = props;

  const gatherData = () => {
    SendDataFunction({
      board_id: formValues.id,
      title: formValues.title,
      description: formValues.description,
      tag: formValues.tag
    })
  }

  const deleteBoard = () => {
    deleteFunction(formValues.id)
  }

  return (
    <Dialog onClose={onClose} open={open}>
      <DialogTitle id="alert-dialog-title">
          Edit Board
        </DialogTitle>
        <DialogContent>
          <DialogContentText id="alert-dialog-description">
            <TextField
              required
              id="id"
              name="id"
              label="Id"
              sx={[styleForTextFields]}
              margin="normal"
              value={formValues.id}
              onChange={handleInputChange}
              />
            <TextField
              required
              id="title"
              name="title"
              label="title"
              sx={[styleForTextFields]}
              margin="normal"
              value={formValues.title}
              onChange={handleInputChange}
              />
          
          <TextField
              required
              id="description"
              name="description"
              label="Description"
              sx={[styleForTextFields]}
              margin="normal"
              value={formValues.email}
              onChange={handleInputChange}
              />

            <br/><br/><label for="cemail">Tag: </label><br/>
            <Autocomplete
              disableClearable
              id="tag"
              onChange={(event, newValue) => {
                setFormValues({
                  ...formValues,
                  tag: newValue,
                  })
              }}
              isOptionEqualToValue={(option, value) => option === value}
              options={Object.values(Tags)}
              getOptionLabel={(option) => option}
              renderInput={(params) => (
                <TextField {...params} variant="standard" sc={{ paddingLeft: '5vw' }} />
              )}
              sx={{ width: '20vw', marginBottom: '10px' }}
            />
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={gatherData}>Save</Button>
          <Button onClick={deleteBoard}>DeleteBoard</Button>
          <Button onClick={onClose}>Close</Button>
        </DialogActions>
    </Dialog>
  );
}

export default EditBoardDialog;