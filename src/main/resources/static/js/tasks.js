alert('da');
// Get references to the form elements
var form = document.getElementById('task-form');
var taskInput = document.getElementById('new-task');
var taskList = document.getElementById('task-list');

// Handle form submissions
form.addEventListener('submit', function(e) {
    e.preventDefault();
    var task = taskInput.value;
    addTask(task);
});

// Add a new task to the list
function addTask(task) {
    let newTask = document.createElement('li');
    newTask.innerHTML = task;
    taskList.appendChild(newTask);
    fetch('/tasks', {
        method: 'POST',
        body: JSON.stringify({ task: task }),
        headers: { 'Content-Type': 'application/json' }
    })
        .then(response => response.json())
        .then(data => {
            let newTask = document.createElement('li');
}
)}
