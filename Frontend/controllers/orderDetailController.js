function loadAllOrderDetails() {
    $.ajax({
        url: baseUrl + 'order/orderdetails',
        type: 'get',
        dataType: 'json',
        success: function (res) {
            $('#order-detail-body').empty();
            for (const detail of res) {

                $('#order-detail-body').append(`<tr>
                <td>${detail.orderId}</td>
                <td>${detail.customerId}</td>
                <td>${detail.itemCode}</td>
                <td>${detail.qty}</td>
                <td>${detail.date}</td>
            </tr>`);

            }
        },
        error: function (err) {
            let mes = JSON.parse(err.responseText);
            alert(mes.message);
        }
    });
}

loadAllOrderDetails();