import axios from "axios";

const requestBoards = (userName, settled, rejected) => {
  return axios({
      method: 'get',
      url: 'http://localhost:8080/api/board/'+userName,
    }).then(settled, rejected)
      .catch((err) => {console.log(err)})
}

const requestBoardChange = (id, boardToEdit, settled, rejected) => {
  return axios.put('http://localhost:8080/api/board/'+parseInt(id), boardToEdit
  ).then(settled, rejected)
    .catch((err) => {console.log(err)})
}

const requestBoardDeletion = (id) => {
  return axios.delete('http://localhost:8080/api/board/'+parseInt(id)
  ).catch((err) => {console.log(err)})
}


export default { requestBoards, requestBoardChange, requestBoardDeletion };