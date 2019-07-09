<?php
/**
 * Created by PhpStorm.
 * User: ht
 * Date: 2019/7/5
 * Time: 18:57
 */

namespace frontend\utils;


class PageUtil {

    private $_total;          //总记录数
    private $_pageSize;           //一页显示的记录数
    private $_page;           //当前页
    private $_pageNum;     //总页数
    private $_start_page;              //起头页数
    private $_end_page;             //结尾页数
    private $_url;            //获取当前的url

    public function __construct($myde_total = 1, $myde_size = 1, $myde_page = 1, $myde_url, $show_pages = 2) {
        $this->_total = $this->numeric($myde_total);
        $this->_pageSize = $this->numeric($myde_size);
        $this->_page = $this->numeric($myde_page);
        $this->_pageNum = ceil($this->_total / $this->_pageSize);
        $this->_url = $myde_url;
        if ($this->_total < 0)
            $this->_total = 0;
        if ($this->_page < 1)
            $this->_page = 1;
        if ($this->_pageNum < 1)
            $this->_pageNum = 1;
        if ($this->_page > $this->_pageNum)
            $this->_page = $this->_pageNum;
        $this->limit = ($this->_page - 1) * $this->_pageSize;
        $this->_start_page = $this->_page - $show_pages;
        $this->_end_page = $this->_page + $show_pages;
        if ($this->_start_page < 1) {
            $this->_end_page = $this->_end_page + (1 - $this->_start_page);
            $this->_start_page = 1;
        }
        if ($this->_end_page > $this->_pageNum) {
            $this->_start_page = $this->_start_page - ($this->_end_page - $this->_pageNum);
            $this->_end_page = $this->_pageNum;
        }
        if ($this->_start_page < 1)
            $this->_start_page = 1;
    }

    //检测是否为数字
    private function numeric($num) {
        if (strlen($num)) {
            if (!preg_match("/^[0-9]+$/", $num)) {
                $num = 1;
            } else {
                $num = substr($num, 0, 11);
            }
        } else {
            $num = 1;
        }
        return $num;
    }

    //地址替换
    private function _pageReplace($page) {
        return str_replace("{page}", $page, $this->_url);
    }

    //首页
    private function _firstPage() {
        if ($this->_page != 1) {
            return "<a href='" . $this->_pageReplace(1) . "' title='首页'>首页</a>";
        } else {
            return "<p>首页</p>";
        }
    }

    //上一页
    private function _prevPage() {
        if ($this->_page != 1) {
            return "<a href='" . $this->_pageReplace($this->_page - 1) . "' title='上一页'>上一页</a>";
        } else {
            return "<p>上一页</p>";
        }
    }

    //下一页
    private function _nextPage() {
        if ($this->_page != $this->_pageNum) {
            return "<a href='" . $this->_pageReplace($this->_page + 1) . "' title='下一页'>下一页</a>";
        } else {
            return"<p>下一页</p>";
        }
    }

    //尾页
    private function _lastPage() {
        if ($this->_page != $this->_pageNum) {
            return "<a href='" . $this->_pageReplace($this->_pageNum) . "' title='尾页'>尾页</a>";
        } else {
            return "<p>尾页</p>";
        }
    }

    //输出
    public function showPage($id = 'page') {
        $str = "<div id=" . $id . ">";
        $str.=$this->_firstPage();
        $str.=$this->_prevPage();
        if ($this->_start_page > 1) {
            $str.="<p class='pageEllipsis'>...</p>";
        }
        for ($i = $this->_start_page; $i <= $this->_end_page; $i++) {
            if ($i == $this->_page) {
                $str.="<a href='" . $this->_pageReplace($i) . "' title='第" . $i . "页' class='cur'>$i</a>";
            } else {
                $str.="<a href='" . $this->_pageReplace($i) . "' title='第" . $i . "页'>$i</a>";
            }
        }
        if ($this->_end_page < $this->_pageNum) {
            $str.="<p class='pageEllipsis'>...</p>";
        }
        $str.=$this->_nextPage();
        $str.=$this->_lastPage();
        $str.="<p class='pageRemark'>共<b>" . $this->_pageNum .
            "</b>页<b>" . $this->_total . "</b>条数据</p>";
        $str.="</div>";
        return $str;
    }

}