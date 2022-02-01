import axios from 'axios'

const GET_TASKS_REST_URL = 'http://localhost:8080/api/tasks';

class TaskService {

    getTasks(){
       return axios.get(GET_TASKS_REST_URL);
    }
}

export default new TaskService();