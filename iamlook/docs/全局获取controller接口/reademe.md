package cn.com.larunda.resource.service.impl;

import cn.com.larunda.resource.service.IResourceFeignService;
import cn.com.larunda.resource.utils.ResourceConst;
import cn.com.larunda.resource.utils.ResourceUtil;
import cn.com.larunda.resource.vo.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源服务.
 *
 * @author yx
 * @version 1.0
 * @since 19-7-23下午3:43
 */
@Service
public class ResourceFallBackImpl implements IResourceFeignService {

    @Autowired
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Override
    public List<ResourceVo> getRequestResource() {

        //所有requestMapping
        Map<RequestMappingInfo, HandlerMethod> allResMap = requestMappingHandlerMapping.getHandlerMethods();
        //只有以/api/开头的 requestMapping
        Map<RequestMappingInfo, HandlerMethod> apiResMap = new HashMap<>(ResourceConst.CAPACITY);
        //过滤获得所有/api/开头的 URL
        allResMap.forEach((k,v)->{
            String url = k.getPatternsCondition().getPatterns().iterator().next();
            if(url.startsWith(ResourceConst.API_RESOURCE)){
                apiResMap.put(k, v);
            }
        });

        List<ResourceVo> resourceList = new ArrayList<>();
        apiResMap.forEach((k,v)->{
            PatternsRequestCondition pattern =  k.getPatternsCondition();
            String url = pattern.getPatterns().iterator().next();
            RequestMethod method = k.getMethodsCondition().getMethods().iterator().next();
            //获得有效 ApiOperation 注解信息
            ResourceVo resourceVo = ResourceUtil.hasApiOperation(v);
            if (resourceVo != null) {
                resourceVo.setMethod(method.name());
                resourceVo.setUrl(url);
                resourceList.add(resourceVo);
            }
        });
        return resourceList;
    }
}