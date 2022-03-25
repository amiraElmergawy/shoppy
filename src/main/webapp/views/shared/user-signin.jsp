<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 3/25/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form sign-in">
  <h2>Sign In</h2>
  <form id="sign-in-form" action="#" method="post">
    <div class="form-group">
      <label>
        <span>Email Address</span>
      </label>
      <input type="email" name="email" id="email" required>
      <div class="error"></div>
    </div>
    <div class="form-group">
      <label>
        <span>Password</span>
      </label>
      <input type="password" name="password" id="password" required>
      <div class="error"></div>
    </div>
    <button class="submit" type="submit">Sign In</button>
  </form>
  <p class="forgot-pass">Forgot Password ?</p>
  <div class="social-media">
    <ul>
      <li><img src="../../assets/images/other/facebook.png"></li>
      <li><img src="../../assets/images/other/twitter.png"></li>
      <li><img src="../../assets/images/other/linkedin.png"></li>
      <li><img src="../../assets/images/other/instagram.png"></li>
    </ul>
  </div>
</div>