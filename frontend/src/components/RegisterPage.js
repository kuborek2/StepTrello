import Footer from './Footer';
import './RegisterPage.css'
import TopNavigation from './TopNavigation';

const RegisterPage = () => {
    return (
        <div>
            <div className='formBox'>
                <form>
                    <label for="login">Login:</label><br/>
                    <input type="text" id="login" name="login"/><br/>

                    <label for="email">Email:</label><br/>
                    <input type="email" id="email" name="email"/><br/>

                    <label for="cemail">Confirm email:</label><br/>
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
        </div>
    );
}

export default RegisterPage;