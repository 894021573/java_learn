package com.ht.springcloudconsumer.common;

import com.ht.mapi.common.HelloRemoteMapiCommom;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("htproduct")
public interface HelloReomteCommon extends HelloRemoteMapiCommom
{

}
