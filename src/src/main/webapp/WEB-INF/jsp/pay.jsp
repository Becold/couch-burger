<%@ include file="include/importTags.jsp" %>
<form:form
        method="POST"
        action="https://www.sandbox.paypal.com/cgi-bin/webscr"
        modelAttribute="payment">
    <input type="hidden" name="business" value="couch.burger@hotmail.com">
    <input type="hidden" name="password" value="EE7oLN7YpJ5qPHyCmkrvlHdJpL6pri-aL1PUHxv5ViTPTmJeQtwFh6uIgsn0Vx9WUCxdkTQCo9_GTgJw">
    <input type="hidden" name="cert_id" value="Aaxjmli5_tyLQf98XIEM7h9pCBopAM4OoGOr4mmYareDLlyHo3k2YUUKjIgPmqtsiQM_7wxA-ySjeUpl">
    <input type="hidden" name="cmd" value="_xclick">
    <input type="hidden" name="amount" value="">
    <input type="hidden" name="item_name" value="">
    <input type="hidden" name="return" value="">
    <input type="hidden" name="cancel_return" value="">
    <input type="hidden" name="currency_code" value="">
    <input type="hidden" name="lc" value="">
</form:form>