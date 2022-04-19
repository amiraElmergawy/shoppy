<%--
  Created by IntelliJ IDEA.
  User: Amira
  Date: 4/18/2022
  Time: 8:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Button trigger modal -->
<p>${empty cart}</p>
<c:choose>
    <c:when test="${empty cart}">
        <h1>There no item </h1>
    </c:when>
    <c:otherwise>
        <button type="button" id="checkout" class="continue btn btn-primary pull-xs-right" data-toggle="modal" data-target="#exampleModalLong">
            CHECKOUT
        </button>
    </c:otherwise>
</c:choose>


<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Confirm Checkout</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="">Are you want to confirm your order?</div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="minus" class="btn shadow-sm btn-sm btn-primary font-weight-bold text-dark mr-1" data-dismiss="modal">Cancel</button>
                <button type="button" id="plus" class="btn shadow-sm btn-sm btn-primary font-weight-bold" onclick="saveOrder()" data-dismiss="modal">Confirm</button>
            </div>
        </div>
    </div>
</div>