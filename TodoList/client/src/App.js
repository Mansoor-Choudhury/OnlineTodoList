import logo from './logo.svg';
import './App.css';
import TaskComponent from "./component/TaskComponent";

function App() {
  return (
    <div className="Todo List" style={
        {
            border: '100px solid white'
        }
    }>
        <TaskComponent/>
    </div>
  );
}

export default App;
