import './frontPage.css'
import Footer from './Footer'

const FrontPage = () => {
    return (
        <div className="pageLayout">
            <div className="topElement">
                <img src={"../resources/frontpage_logo_background.jpeg"}/>
                <article>
                    <h1>StepTrello</h1>
                    <p>
                        Personal organizer for your needs.
                        It allows you to create boards for many acitvies.
                        Each board can be organazied how ever u like.
                        You find yourself forgetting things.
                        Not anymore.
                        Register today to see how smoothly your day can go.
                    </p>
                    <div className='buttonSpace'>
                        <button>
                            Sign in
                        </button>
                        <button>
                            Register
                        </button>
                </div>
                </article>
            </div>
            <footer>
                <Footer/>
            </footer>
        </div>
    );
  }
  
  export default FrontPage;