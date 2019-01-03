<%@ include file="include/importTags.jsp" %>

<div class="mt-5 container text-center">

    <form method="POST" action="https://www.sandbox.paypal.com/cgi-bin/webscr">
        <input type="hidden" name="business" value="couch.burger@hotmail.com">
        <input type="hidden" name="password" value="EE7oLN7YpJ5qPHyCmkrvlHdJpL6pri-aL1PUHxv5ViTPTmJeQtwFh6uIgsn0Vx9WUCxdkTQCo9_GTgJw">
        <input type="hidden" name="cert_id" value="Aaxjmli5_tyLQf98XIEM7h9pCBopAM4OoGOr4mmYareDLlyHo3k2YUUKjIgPmqtsiQM_7wxA-ySjeUpl">
        <input type="hidden" name="cmd" value="_xclick">
        <input type="hidden" name="amount" value="${amount}">
        <input type="hidden" name="item_name" value="${item_name}">
        <input type="hidden" name="return" value="${return_url}">
        <input type="hidden" name="cancel_return" value="${cancel_return_url}">
        <input type="hidden" name="currency_code" value="${currency_code}">
        <input type="hidden" name="lc" value="${lc}">
        <input type="submit" class="btn btn-success" value="<spring:message code="pay.paypal" />" />
    </form>

</div>