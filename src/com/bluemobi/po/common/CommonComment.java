package com.bluemobi.po.common;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【评论表】持久化对象 数据库表：common_comment
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class CommonComment extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 评论id
    private Integer id;
    // 用户id
    private Integer userId;
    // 评论类型：1、订单明细(商品) 2、物流服务(子订单)  3、服务态度(子订单)
    private Integer type;
    // 评论目标id
    private Integer targetId;
    // 评分
    private Integer score;
    // 评论内容
    private String content;
    // 评论时间
    private Date ctime;
    // 审核状态：0、未审核 1、审核通过 2、审核不通过
    private Integer status;
    
    //附加字段（查詢用）
    private String orderChildNo;
    private Integer orderType;
    private String goodsName;
    private String merchantName;
    private String userName;
    private String phone;
    private Integer rankBase;
    private Integer rankSpeed;
    private Integer rankService;
    private Integer sumScore;

    /** 获取 评论id */
    public Integer getId() {
        return id;
    }

    /** 设置 评论id */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 用户id */
    public Integer getUserId() {
        return userId;
    }

    /** 设置 用户id */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /** 获取 评论类型：1、订单明细(商品) 2、物流服务(子订单)  3、服务态度(子订单) */
    public Integer getType() {
        return type;
    }

    /** 设置 评论类型：1、订单明细(商品) 2、物流服务(子订单)  3、服务态度(子订单) */
    public void setType(Integer type) {
        this.type = type;
    }

    /** 获取 评论目标id */
    public Integer getTargetId() {
        return targetId;
    }

    /** 设置 评论目标id */
    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    /** 获取 评分 */
    public Integer getScore() {
        return score;
    }

    /** 设置 评分 */
    public void setScore(Integer score) {
        this.score = score;
    }

    /** 获取 评论内容 */
    public String getContent() {
        return content;
    }

    /** 设置 评论内容 */
    public void setContent(String content) {
        this.content = content;
    }

    /** 获取 评论时间 */
    public Date getCtime() {
        return ctime;
    }

    /** 设置 评论时间 */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /** 获取 审核状态：0、未审核 1、审核通过 2、审核不通过 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 审核状态：0、未审核 1、审核通过 2、审核不通过 */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderChildNo() {
		return orderChildNo;
	}

	public void setOrderChildNo(String orderChildNo) {
		this.orderChildNo = orderChildNo;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getRankBase() {
		return rankBase;
	}

	public void setRankBase(Integer rankBase) {
		this.rankBase = rankBase;
	}

	public Integer getRankSpeed() {
		return rankSpeed;
	}

	public void setRankSpeed(Integer rankSpeed) {
		this.rankSpeed = rankSpeed;
	}

	public Integer getRankService() {
		return rankService;
	}

	public void setRankService(Integer rankService) {
		this.rankService = rankService;
	}

	public Integer getSumScore() {
		return sumScore;
	}

	public void setSumScore(Integer sumScore) {
		this.sumScore = sumScore;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CommonComment");
        sb.append("{id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", type=").append(type);
        sb.append(", targetId=").append(targetId);
        sb.append(", score=").append(score);
        sb.append(", content=").append(content);
        sb.append(", ctime=").append(ctime);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommonComment) {
            CommonComment commonComment = (CommonComment) obj;
            if (this.getId().equals(commonComment.getId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getId();
        return pkStr.hashCode();
    }

}