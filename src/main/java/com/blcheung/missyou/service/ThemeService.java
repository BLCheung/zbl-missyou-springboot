package com.blcheung.missyou.service;

import com.blcheung.missyou.model.Theme;
import com.blcheung.missyou.repository.ThemeRepository;
import com.blcheung.missyou.vo.ThemeVO;
import com.blcheung.missyou.vo.ThemeSpuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    /**
     * 获取一组专题
     *
     * @param names
     * @return
     */
    public List<ThemeVO> getThemeByNames(String names) {
        List<String> nameList = Arrays.asList(names.split(","));
        List<Theme> themeList = this.themeRepository.findByNames(nameList);
        return themeList.stream()
                        .map(ThemeVO::new)
                        .collect(Collectors.toList());
    }

    /**
     * 获取一个专题（包含Spu）
     *
     * @param name
     * @return
     */
    public ThemeSpuVO getThemeWithSpu(String name) {
        Theme theme = this.themeRepository.findByName(name);
        return new ThemeSpuVO(theme);
    }
}
