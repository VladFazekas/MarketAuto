
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


 <h1 class="my-4">MotoShop</h1>
          <div class="list-group">
          <c:forEach items = "${categories}" var ="category">
            <a href="/MarketAuto/category-${category.id}-allProducts" class="list-group-item">${category.name}</a>
          </c:forEach>
          </div>
