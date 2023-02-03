import axios from "axios";

const requestBoards = (userName, token, settled, rejected) => {
  // return axios({
  //     method: 'get',
  //     url: 'http://localhost:8080/api/board/'+userName,
  //     headers: {access_token: "Bearer "+token}
  //   }).then(settled, rejected)
  //     .catch((err) => {console.log(err)})
  const tokenAsString = "Bearer "+String(token)
  const config = {
    headers: {access_token: tokenAsString}
  }
  return axios.get('http://localhost:8080/api/board/'+userName, config
  ).then(settled, rejected)
    .catch((err) => {console.log(err)})
}

const requestBoardChange = (id, token, boardToEdit, settled, rejected) => {
  const tokenAsString = "Bearer "+String(token)
  const config = {
    headers: {
      access_token: tokenAsString,
    }
  }
  return axios.put('http://localhost:8080/api/board/'+parseInt(id), boardToEdit, config
  ).then(settled, rejected)
    .catch((err) => {console.log(err)})
}

const requestBoardDeletion = (id, token) => {
  const tokenAsString = "Bearer "+String(token)
  const config = {
    headers: {access_token: tokenAsString}
  }
  return axios.delete('http://localhost:8080/api/board/'+parseInt(id), config
  ).catch((err) => {console.log(err)})
}


export default { requestBoards, requestBoardChange, requestBoardDeletion };