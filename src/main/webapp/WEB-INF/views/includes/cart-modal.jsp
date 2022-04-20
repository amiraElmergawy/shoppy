<%--
  Created by IntelliJ IDEA.
  User: Amira
  Date: 4/18/2022
  Time: 8:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Button trigger modal -->

<button type="button" id="checkout" class="continue btn btn-primary pull-xs-right" data-toggle="modal" data-target="#exampleModalLong">
    CHECKOUT
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Choose payment method</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="">Pay by?</div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="minus" class="btn shadow-sm btn-sm btn-primary font-weight-bold text-dark mr-1" data-dismiss="modal">Cancel</button>
                <a class="btn shadow-sm btn-sm btn-primary font-weight-bold" href="payment">Visa</a>
                <button type="button" id="plus" class="btn shadow-sm btn-sm btn-primary font-weight-bold ml-1" onclick="saveOrder()" data-dismiss="modal">Your Credit</button>
            </div>
        </div>
    </div>
</div>