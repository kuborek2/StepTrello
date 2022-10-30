import './SignInPage.css'

const SignInPage = () => {
    return (
        <div>
            <div className='formBox'>
                <form>
                    <label for="login">Login:</label><br/>
                    <input type="text" id="login" name="login"/><br/>

                    <label for="password">Password:</label><br/>
                    <input type="password" id="password" name="password"/><br/>

                    <button>
                        Log in
                    </button>
                </form>
            </div>
        </div>
    );
}

export default SignInPage;