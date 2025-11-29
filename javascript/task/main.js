import { Task, TaskStatus } from './task.js';
import TaskList from './task-list.js';

const showTasks = (taskList) => {
    taskList.forEach(item => {
        showTask(item)
    });
}

const showTask = (item) => {
    if (item === null) {
        console.log(`Task not found`)
        return
    }

    console.log(`Task ${item.id}: ${item.description} | Tag: ${item.tag} | Status: ${item.status}`)
}

const task1 = new Task(1, 'Complete the project documentation', 'Work');
const task2 = new Task(2, 'Buy groceries', 'Personal', TaskStatus.COMPLETED);
const task3 = new Task(3, 'Reading a Book', 'Study', TaskStatus.COMPLETED);
const task4 = new Task(4, 'Daily with a team', 'Meeting');
const task5 = new Task(5, 'Review other project', 'Meeting');
const task6 = new Task(6, 'Running', 'Personal');
const task7 = new Task(7, 'Reading article', 'Study');

const taskList = new TaskList();

taskList.addTask(task1);
taskList.addTask(task2);
taskList.addTask(task3, 0);
taskList.addTask(task4, 10);
taskList.addTask(task4);
taskList.addTask(task5, 2);
taskList.addTask(task6);
taskList.addTask(task7);

showTasks(taskList.getTasks());

console.log("Show tasks by job: ")
showTasks(taskList.getTasksByTag("Work"));

console.log("Show tasks by job: ")
showTasks(taskList.getTasksByTag("Meeting"));

console.log("Show tasks by job: ")
showTasks(taskList.getTasksByTag("Jobs"));

console.log("Show task by id: 3")
showTask(taskList.getTasksById(3));

console.log("Show task by id: 7")
showTask(taskList.getTasksById(7));

console.log("Remove task by id: 2")
taskList.removeTaskById(2);
showTasks(taskList.getTasks());

console.log("Mark task as completed by id: 1")
taskList.setTaskToCompleted(1);
showTask(taskList.getTasksById(1));

console.log("Update TaskData: 7")
taskList.setTaskDataById(7, new Task(null, "Reading working article", "Job"));
showTask(taskList.getTasksById(7));

console.log("Move task...")
console.log(taskList.move(7, 1));
showTasks(taskList.getTasks());