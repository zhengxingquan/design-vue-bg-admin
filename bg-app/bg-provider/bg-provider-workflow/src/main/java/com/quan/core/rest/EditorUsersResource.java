package com.quan.core.rest;

import org.flowable.idm.api.User;
import org.flowable.ui.common.model.ResultListDataRepresentation;
import org.flowable.ui.common.model.UserRepresentation;
import org.flowable.ui.common.service.idm.RemoteIdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pm 1280415703@qq.com
 * @date 2019/10/26 12:06
 */
@RestController
@RequestMapping("/app")
public class EditorUsersResource {

    @Autowired
    protected RemoteIdmService remoteIdmService;

    @GetMapping(value = "/rest/editor-users")
    public ResultListDataRepresentation getUsers(@RequestParam(value = "filter", required = false) String filter) {
        List<? extends User> matchingUsers = remoteIdmService.findUsersByNameFilter(filter);
        List<UserRepresentation> userRepresentations = new ArrayList<>(matchingUsers.size());
        for (User user : matchingUsers) {
            userRepresentations.add(new UserRepresentation(user));
        }
        return new ResultListDataRepresentation(userRepresentations);
    }
}
