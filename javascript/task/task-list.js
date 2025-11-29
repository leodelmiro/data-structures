import LinkedList from "./linked-list.js";
import { TaskStatus } from "./task.js";

export default class TaskList {
    constructor() {
        this.tasks = new LinkedList();
    }

    getTasks() {
        return this.tasks.toArray();
    }

    getTasksByTag(tag) {
        let current = this.tasks.head
        const tasksByTag = []

        while (current) {
            if (current.value.tag === tag) {
                tasksByTag.push(current.value)
            }
            current = current.next
        }

        return tasksByTag
    }


    getTasksById(id) {
        let current = this.tasks.head

        while (current) {
            if (current.value.id === id) {
                return current.value
            }
            current = current.next
        }

        return null
    }


    addTask(task, index = null) {
        if (index === null) {
            this.tasks.addAtEnd(task);
            return
        }

        if (!this.tasks.get(index)) return

        this.tasks.addAt(index, task);
    }

    removeTaskById(id) {
        const taskItem = this.getTasksById(id)

        if (taskItem) {
            return this.tasks.remove(taskItem)
        }

        return null
    }

    setTaskToCompleted(id) {
        const taskItem = this.getTasksById(id)

        if (taskItem) {
            taskItem.status = TaskStatus.COMPLETED
        }

        return taskItem
    }

    setTaskDataById(id, task) {
        const taskItem = this.getTasksById(id)

        if (taskItem) {
            taskItem.description = task.description
            taskItem.status = task.status
            taskItem.tag = task.tag
        }

        return taskItem
    }

    move(id, targetIndex) {
        const taskItem = this.getTasksById(id)

        if (!taskItem) return

        this.tasks.remove(taskItem)
        this.tasks.addAt(targetIndex, taskItem)
    }

}