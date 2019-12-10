package cn.chingshen.smartlab.services;

import cn.chingshen.smartlab.mappers.SampleMapper;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public SampleMapper sampleMapper;

    public SampleService(SampleMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }
    //    public List<Sample> samples() {
//
//    }

    /**
     * 样本签收
     */
    public void receive() {

    }

    public Integer delete() {
        return 1;
    }
}
