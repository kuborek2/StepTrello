import axios from "axios";

/** 
 * Example user needed
 * 
 * user = {
 *  login: "something"
 *  email: "email@emial.com"
 *  password: "yaikes"
 * }
*/

const requestUserRegistration = (newUser, settled, rejected) => {
  return axios({
    method: 'put',
    url: 'http://localhost:8080/api/user',
    data: newUser
  }).then(settled, rejected)
    .catch((err) => {console.log(err)})
}

const requestLogIn = (credentials ,settled, rejected) => {
  return axios({
    method: 'get',
    url: 'http://localhost:8080/api/user/?login='+credentials.login,
  }).then(settled, rejected)
    .catch((err) => {console.log(err)})
}

export default { requestUserRegistration, requestLogIn };