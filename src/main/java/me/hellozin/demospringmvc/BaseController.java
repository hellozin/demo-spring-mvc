package me.hellozin.demospringmvc;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = {EventController.class, FileController.class})
public class BaseController {

    /* 모든 컨트롤러에 적용 */

}
