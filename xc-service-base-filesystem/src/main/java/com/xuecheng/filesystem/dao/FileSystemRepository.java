package com.xuecheng.filesystem.dao;

import com.xuecheng.framework.domain.filesystem.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName FileSystemRepository
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/4/12 10:01
 * @Version 1.0
 **/
public interface FileSystemRepository extends MongoRepository<FileSystem,String> {
}
