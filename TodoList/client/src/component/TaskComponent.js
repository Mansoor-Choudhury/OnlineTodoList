import React, {useState} from "react";
import TaskService from "../service/TaskService";
import AddTodo from "./AddTodo";
import axios from "axios";

class TaskComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            tasks:[]
        }
    }


    componentDidMount() {
        TaskService.getTasks().then((response) => {
           this.setState({tasks : response.data})
        });
    }

     deleteHandler = e => {
        axios.post('http://localhost:8080/api/deleteTodo', e.target.value)
    }

    render() {
        return (
         <form className="todoList-Form">
             <h1 className="text-center">Welcome to your todo List!</h1>
             <br/>
             <AddTodo/>
             <br/>
             <div >
                 <table className="table table-striped" >
                 <thead style={
                     {
                         background: 'lightblue'
                     }
                 }>
                     <tr>
                         <th>Tasks</th>
                         <th>Last Updated</th>
                         <th>Action</th>
                     </tr>
                 </thead>
                 <tbody>
                 {
                     this.state.tasks.map(
                         task =>
                             <tr key={task.taskId}>
                                 <td>{task.taskName}</td>
                                 <td>{task.updateDate}</td>
                                 <td>
                                     <button name="deleteToDo" value={task.taskId} onClick={this.deleteHandler}>Delete</button>
                                 </td>
                             </tr>
                     )
                 }
                 </tbody>
             </table>
             </div>
         </form>
        )
    }
}

export default TaskComponent;