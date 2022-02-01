import React, {useState} from "react";
import axios from 'axios'

class AddTodo extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            todoDescription: ''
        }
    }

    changeHandler = e => {
        this.setState({todoDescription : e.target.value})
    }

    submitHandler = e => {
        console.log(this.state.todoDescription.toString())
        axios.post('http://localhost:8080/api/addTodo', this.state.todoDescription.toString())
    }

    render() {
        const {todoDescription} = this.state
        return (
            <form>
            <div>
                <input type="text" name="todoDescription" placeholder="Add Todo!" onChange={this.changeHandler}/>
                <button className="add-todo" onClick={this.submitHandler}>Add Todo</button>
            </div>
            </form>
        )
    }

}

export default AddTodo;