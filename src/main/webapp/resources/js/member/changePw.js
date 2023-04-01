

const infoUpdateBtn = document.getElementById("info-update-btn");
const currentPw = document.getElementById("currentPw");
const newPw = document.getElementById("newPw");
const newPwConfirm = document.getElementById("newPwConfirm");

infoUpdateBtn.addEventListener("click", function() {
    if(newPw.value == newPwConfirm.value) {

        $.ajax({
            url: "changePw",
            data: {"currentPw" : currentPw.value,
                    "newPw" : newPw.value,
                    "newPwConfirm" : newPwConfirm.value
            },
            type: "POST",

            success: function(result) {
                if(result > 0) {
                    alert("변경해줄게~");
                    return true;
                }else {
                    alert("비밀번호가 일치하지 않습니다.");
                    return false;
            }
        }

        }) 
    } else {
        alert("비밀번호가 서로 일치하지 않아");
        return false;
    }

         
   
    
});