
<div class="invoice-box container">
    <table>
        <tr class="top">
            <td colspan="4">
                <div class="row">
                    <div class="title col-7">
                        <img src="assets/images/home/llogo.png" alt="Shoopy logo" class="img-fluid w-50" />
                    </div>
                    <div class="col-5">
                        Invoice #: ${order.getId()}<br/>
                        Created:  ${order.getCreatedAt()}<br/>
                    </div>
                </div>
            </td>
        </tr>

        <tr class="information">
            <td colspan="4">
                <table>
                    <tr>
                        <td>
                            ${order.getCustomer().getAddress().getArea()}.<br/> Building Number , ${order.getCustomer().getAddress().getBuildingNum()} , ${order.getCustomer().getAddress().getStreet()}<br/> Floor number ,${order.getCustomer().getAddress().getFloorNum()}
                        </td>

                        <td>
                            ${order.getCustomer().getUsername()}.<br />
                                ${order.getCustomer().getEmail()}
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr class="heading">
            <td>Payment Method</td>
            <td></td>
            <td></td>
            <td>Stripe</td>
        </tr>

        <tr class="details">
            <td>Credit card</td>
        </tr>

        <tr class="heading">
            <td>Item</td>
            <td>Quntity</td>
            <td>Price</td>
            <td>Total Price</td>
        </tr>
        <c:forEach var="productOrder" items="${order.getOrderProducts()}">
        <tr class="item">
            <td>${productOrder.getProduct().getProductName()}</td>
            <td>${productOrder.getQuantity()}</td>
            <td>${productOrder.getProduct().getPrice()}</td>
            <td>${productOrder.getTotal()}</td>
        </tr>
        </c:forEach>
        <tr class="total">
            <td>Total amount :${order.getTotalPrice()}</td>
        </tr>
    </table>
</div>