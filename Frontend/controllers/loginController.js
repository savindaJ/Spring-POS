$('#btn-sign-in').on('click', function () {
    let txtEmail = $('#txt-email').val();
    let pw = $('#txt-pw').val();

    const myUser = {
        gmail: txtEmail,
        password: pw
    }

    console.log(myUser)

    $.ajax({
        url: baseUrl + 'auth/login',
        type: 'post',
        contentType: 'application/json',
        data: JSON.stringify(myUser),
        success: function (res) {
            let timerInterval;
            Swal.fire({
                title: "Login SuccessFull !!!, Please Wait...",
                html: "I will close in <b></b> milliseconds.",
                timer: 2000,
                timerProgressBar: true,
                didOpen: () => {
                    Swal.showLoading();
                    const timer = Swal.getPopup().querySelector("b");
                    timerInterval = setInterval(() => {
                        timer.textContent = `${Swal.getTimerLeft()}`;
                    }, 100);
                },
                willClose: () => {
                    clearInterval(timerInterval);
                }
            }).then((result) => {
                    window.location.href = "pages/main.html";
            });
        },
        error: function (err) {
            const Toast = Swal.mixin({
                toast: true,
                position: "top-end",
                showConfirmButton: false,
                timer: 3000,
                timerProgressBar: true,
                didOpen: (toast) => {
                    toast.onmouseenter = Swal.stopTimer;
                    toast.onmouseleave = Swal.resumeTimer;
                }
            });
            Toast.fire({
                icon: "error",
                title: JSON.parse(err.responseText).message
            });
        }
    });
});

$('#btn-register').on('click', function () {
    window.location.href = 'pages/signup.html';
});