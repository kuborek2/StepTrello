import './AddBoard.css'
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import { useState } from 'react';
import Tags from '../../../enums/Tags';

const AddBoard = () => {

  const [selectedOptions, setSelectedOptions] = useState([]);
  const [selectedTag, setSelectedTag] = useState("");

  const top100Films = [
    { title: 'The Shawshank Redemption', year: 1994 },
    { title: 'The Godfather', year: 1972 },
    { title: 'The Godfather: Part II', year: 1974 },
    { title: 'The Dark Knight', year: 2008 },
    { title: '12 Angry Men', year: 1957 },
    { title: "Schindler's List", year: 1993 },
    { title: 'Pulp Fiction', year: 1994 }
  ]

  const SubmitAddBoardForm = () => {
    // TODO : Add element to the boardSlice list of boards. Call backend request to add board and move to the board page
  }

  return (
    <div className='addFormBox'>
      <form>
        <label for="login">Name:</label><br/>
        <input type="text" id="login" name="login"/><br/>

        <label for="cemail">Collabolators:</label><br/>
        <Autocomplete
          disableClearable
          multiple
          id="multiple-limit-collabolators"
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
        /><br/>

        <label for="cemail">Tag: </label><br/>
        <Autocomplete
          disableClearable
          id="tag"
          onChange={(event, newValue) => {
            setSelectedTag(newValue);
          }}
          isOptionEqualToValue={(option, value) => option === value}
          options={Object.values(Tags)}
          getOptionLabel={(option) => option}
          renderInput={(params) => (
            <TextField {...params} variant="standard" sc={{ paddingLeft: '5vw' }} />
          )}
          sx={{ width: '20vw', marginBottom: '10px' }}
        />

        <div>
          <button onClick={() => SubmitAddBoardForm}>
            Submit
          </button>
        </div>
      </form>
    </div>
  );
}

export default AddBoard;