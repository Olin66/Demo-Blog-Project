package sustech.blog.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public JsonResult<Exception> handler(ShiroException e) {
        log.error("ShiroException!");
        return new JsonResult<>(6002, e);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public JsonResult<Exception> handler(RuntimeException e) {
        log.error("RuntimeException!");
        return new JsonResult<>(6000, e);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public JsonResult<Exception> handler(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException!");
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        return new JsonResult<>(6001, objectError.getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public JsonResult<Exception> handler(IllegalArgumentException e) {
        log.error("IllegalArgumentException!");
        return new JsonResult<>(6003, e);
    }
}
