// miniprogram/pages/detail/detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    indicatorDots: true,
    autoplay: true,
    interval: 3000,
    duration: 500,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
//1.获取bmid
  var id = options.bmid;
  console.log(id)
  wx.request({
    url: 'http://localhost:9090/BMProgram_war/bm/selectOne',
    data:{
      bmid:id
    },
    success:this.setbminfo.bind(this)
  })
  },
  setbminfo:function(res){
    console.log(res.data.bm);
    this.setData({"bminfo":res.data.bm})
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
  gotoappointment:function(e){
    //获取wxml中当前按钮中的 data-***属性的键值对s
    var d = e.currentTarget.dataset;
   // d.bmid;
    //d.salary
    wx.navigateTo({
      url: '../appointment/appointment?bmid='+d.bmid+'&salary='+d.salary
    })
  }
})