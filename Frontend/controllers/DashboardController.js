function setStatus() {
    $.ajax({
        method: 'GET',
        url: baseUrl,
        dataType: 'json',
        success: function (res) {
            console.log(res);
                $('#income').text(res.income);
                $('#totOfCustomers').text(res.customerCount);
                $('#totOfItems').text(res.itemCount);
                $('#totOfOrders').text(res.orderCount);
                $('#finishOrders').text(res.orderDetailCount);

        },
        error: function (err) {
            // let error = JSON.parse(err.responseText);
            console.log(err);
        }
    })

}

setStatus();