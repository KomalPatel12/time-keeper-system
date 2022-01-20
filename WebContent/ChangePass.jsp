    //ChangePassword.jsp
    <FORM ACTION="ChangePassword" METHOD="GET">
<div id="login_box">
  <div id="login_header">
        Login
  </div>
  <div id="form_val">
    <div class="label">employeeid:</div>
    <div class="control"><input type="text" name="employeeid" id="employeeid"/></div>

    <div class="label">Password:</div>
    <div class="control"><input type="password" name="Password" id="Password"/></div>

    <div class="label">Confirm Password:</div>
    <div class="control"><input type="password" name="Password" id="Password"/></div>
    <div style="clear:both;height:0px;"></div>

    <div id="msgbox"></div>
  </div>

  <div id="login_footer">
  <!-- <script type="text/javascript">
  function closewindow() {
  window.close()
  }
  </script>-->
     <label>
    <input type="submit" onclick="location.href='http://localhost:8080/IntegrateAll/Index.jsp'" window.close();" name="Submit" id="Submit" value="Submit" class="send_button" />
    </label>
  </div>
</div>