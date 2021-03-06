// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// See the License for the specific language governing permissions and
// limitations under the License.

package syncer.transmission.mapper;

import org.apache.ibatis.annotations.*;
import syncer.transmission.model.BigKeyModel;

import java.util.List;

/**
 * @author zhanenqiang
 * @Description 描述
 * @Date 2020/7/6
 */

//@Component
@Mapper
public interface BigKeyMapper {
    @Select("SELECT * FROM t_big_key WHERE taskId =#{taskId}")
    List<BigKeyModel> findBigKeyCommandListByTaskId(@Param("taskId") String taskId)throws Exception;

    @Insert("INSERT INTO t_big_key(taskId,command,command_type) VALUES(#{taskId},#{command},#{command_type})")
    boolean insertBigKeyCommandModel(BigKeyModel bigKeyModel)throws Exception;

    @Delete("DELETE FROM t_big_key WHERE id=#{id}")
    void deleteBigKeyCommandModelById(@Param("id") String id)throws Exception;

    @Delete("DELETE FROM t_big_key WHERE taskId=#{taskId}")
    void deleteBigKeyCommandModelByTaskId(@Param("taskId") String taskId)throws Exception;

    @Delete("DELETE FROM t_big_key WHERE groupId=#{groupId}")
    void deleteBigKeyCommandModelByGroupId(@Param("groupId") String groupId)throws Exception;
}
