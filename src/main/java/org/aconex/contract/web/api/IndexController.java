package org.aconex.contract.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by muthukumar on 4/5/16.
 */

@Controller
class IndexController {

    @RequestMapping("/")
    public String index() {
        return "contracts";
    }

}
