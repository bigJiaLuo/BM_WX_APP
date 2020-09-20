//index.js
const app = getApp()

Page({
  data: {
    "bminfos":[
    ]
  },

  /**
   * 存放其他页面跳转到此页面的数据
   * @param {存放其他页面跳转到此页面的数据} options 
   */
  onLoad: function(options) {
    var that = this;
    wx.request({
      url: 'http://localhost:9090/BMProgram_war/bm/selectAll',
      // 看不懂
      success: function(res){
        var list = res.data.list;
        console.log(res.data.list[0]+"我来了")
        if(list == null){
          console.log("错误错误");
        }else{
          that.setData({bminfos:list});
        }
      }
    });
  },

    getInfos:function(res){
      this.setData({"bminfos":res.data.bminfos})
      console.log(res.data);
    },

  
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  /**
   * 前往详情页
   */
  gotodetail:function(e){ 
    //接收wxml中的data-**设置的数据
    var data = e.currentTarget.dataset;
    console.log(data);
    wx.navigateTo({
      url: '../detail/detail?bmid='+data.mid
    })
  },

  goUserInfo:function(e){
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({userInfo:e.detail.userInfo,hasUserInfo:true})
  }
})
