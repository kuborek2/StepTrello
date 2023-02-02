import axios from "axios";
import qs from 'qs';

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
    method: 'post',
    url: 'http://localhost:8080/api/user',
    data: newUser
  }).then(settled, rejected)
    .catch((err) => {console.log(err)})
}

const requestLogIn = (credentials, settled, rejected) => {
  const dataToSend = {
    username: credentials.login,
    password: credentials.password
  }
  return axios({
    method: 'post',
    url: 'http://localhost:8080/login',
    data: qs.stringify(dataToSend)
  }).then(settled, rejected)
    .catch((err) => {console.log(err)})
}

export default { requestUserRegistration, requestLogIn };