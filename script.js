//Global area

window.onload=function() {
    //Try and use classname to get a group of divs instead of getting them one by one by id
    //if you are writing the same type of code multiple times, you are doing it incorrect
    
    //Attach events using eventlistener here
    var boxes = document.getElementsByClassName('col');
    for(var i = 0; i < boxes.length; i++) {
        boxes[i].addEventListener('click', userTurn);
    }
    var reset = document.getElementById('reset');
    reset.addEventListener('click', resetGameBoard);
}
    
/************** Function area *******************/

//function provided. Add parameter(s) if needed
function userTurn()
{
    this.innerHTML = 'X';
    this.style.backgroundColor = 'green';
    determineWinner('X');
    computerTurn();
}

//function provided. Add parameter(s) if needed
function computerTurn()
{
    var boxes2 = document.getElementsByClassName('col');
    for(var i = 0; i < boxes2.length; i++) {
        if(boxes2[i].innerHTML != 'X' && boxes2[i].innerHTML != 'O') {
            boxes2[i].innerHTML = 'O';
            boxes2[i].style.backgroundColor = 'green';
            break;
        }
    }
    determineWinner('O');
}

//function to determine if the game has been won
function determineWinner(elem)
{
    var turn = elem;
    var winningPos = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6],
    ];

    var box = [];
    for(var i = 0; i < 9; i++) {
        box.push(document.getElementById('' + i));
    }
    var status = document.getElementById('status');
    var message = document.getElementById('message');
    for(var i = 0; i < winningPos.length; i++) {
        if(box[winningPos[i][0]].innerHTML === box[winningPos[i][1]].innerHTML &&
           box[winningPos[i][0]].innerHTML === box[winningPos[i][2]].innerHTML &&
           box[winningPos[i][0]].innerHTML != '') {

            if(turn === 'X') {
                status.innerHTML = 'Game Over';
                message.innerHTML = 'User is the winner!!!';
                break;
            }
            else if(turn === 'O'){
                status.innerHTML = 'Game Over';
                message.innerHTML = 'Computer is the winner!!!';
                break;
            }
        }
    }
}

//function to reset the game board
function resetGameBoard() {
    var boxes = document.getElementsByClassName('col');
    var status = document.getElementById('status');
    var message = document.getElementById('message');

    status.innerHTML = 'This is a new game!!! Click on any of the squares to start the game';
    message.innerHTML = '';
    for(var i = 0; i < boxes.length; i++) {
        boxes[i].innerHTML = '';
        boxes[i].style.backgroundColor = 'white';
    }
}
