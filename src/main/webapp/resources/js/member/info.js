const infoUpdateBtn = document.getElementById("info-update-btn");
const memberNickname = document.getElementById("memberNickname");
const memberTel = document.getElementById("memberTel");


infoUpdateBtn.addEventListener("click", function() {
    if(memberNickname.value && memberTel.value) {  

        $.ajax({
            url: "info",
            data: {"memberNickname" : memberNickname.value,
                    "memberTel" : memberTel.value 
                },
            type: "POST",

            success: function(result) {
                if(result == 0){ 
                    alert("완료~");
                    return true;
					
                } else { // 닉네임 중복 O
                    alert("이미 사용 중인 닉네임 입니다.");
                    return false;
                    
                }
            },
            error: function() {
                alert("에러~?!");
                return false;
            }
        });

        return true;

    } else {
        console.log("닉네임 양식 틀렸어~")
        return false;
    }

    
});

