package gov.iti.jets.shoppy.presentation.listeners;

import gov.iti.jets.shoppy.service.DomainFacade;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.Optional;

public class SessionListener implements HttpSessionListener {
    public void sessionDestroyed(HttpSessionEvent se) {
       handleShoppingCart(se);
    }

    private void handleShoppingCart(HttpSessionEvent sessionEvent) {
        Optional<OrderDto> orderDtoOptional = Optional.empty();
        OrderDto orderDto = (OrderDto) sessionEvent.getSession().getAttribute("cart");
        if(orderDto != null)
            orderDtoOptional = Optional.of(orderDto);
        DomainFacade.getInstance().saveShoppingCart(orderDtoOptional);
    }
}
