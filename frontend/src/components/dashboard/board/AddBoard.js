import './AddBoard.css'

const AddBoard = () => { 
  return (
      <div className='formBox'>
        <form>
          <label for="login">Name:</label><br/>
          <input type="text" id="login" name="login"/><br/>

          <label for="cemail">Collabolators:</label><br/>
          <input type="email" id="cemail" name="cemail"/><br/>

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