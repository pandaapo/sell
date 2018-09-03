package com.panda.utils;

import com.panda.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVo = new ResultVO();
        resultVo.setData(object);
        resultVo.setMsg("成功！");
        resultVo.setCode(0);
        return resultVo;
    }

    public  static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return  resultVO;
    }
}
