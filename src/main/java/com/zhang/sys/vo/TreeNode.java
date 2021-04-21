package com.zhang.sys.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单返回对象
 */
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode{

    private Integer id;

    @JsonProperty("parentId")
    private Integer pid;

    private String title;

    private String href;
    /**
     * 0不展开1展开
     */
    private Boolean spread;

    private String target;

    private String icon;

    @JsonProperty("checkArr")
    private String checkArr = "0";

    private List<TreeNode> children = new ArrayList<>();

    private Integer available;

    public TreeNode(Integer id, Integer pid, String title, String href, boolean spread, String target, String icon) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.href = href;
        this.spread = spread;
        this.target = target;
        this.icon = icon;
    }


    public TreeNode(Integer id, Integer pid, String title, String href, boolean spread, String target, String icon, String checkArr) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.href = href;
        this.spread = spread;
        this.target = target;
        this.icon = icon;
        this.checkArr = checkArr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isSpread(){
        return spread;
    }
    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCheckArr() {
        return checkArr;
    }

    public void setCheckArr(String checkArr) {
        this.checkArr = checkArr;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", pid=" + pid +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", spread=" + spread +
                ", target='" + target + '\'' +
                ", icon='" + icon + '\'' +
                ", checkArr='" + checkArr + '\'' +
                ", children=" + children +
                ", available=" + available +
                '}';
    }
}
