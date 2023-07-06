<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="number" id="quantity" onchange="updateTotalPrice()" />
<input type="number" id="price" onchange="updateTotalPrice()" />
<input type="number" id="totalPrice" readonly />

<script>
function updateTotalPrice() {
  var quantity = parseFloat(document.getElementById("quantity").value);
  var price = parseFloat(document.getElementById("price").value);
  var totalPrice = quantity * price;

  document.getElementById("totalPrice").value = totalPrice;
}
</script>

</body>
</html>