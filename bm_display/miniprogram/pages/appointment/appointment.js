// pages/appointment/appointment.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //options对象中就有前面转过来的键值对
    // url: '../appointment/appointment?bmid='+d.bmid+'&salary='+d.salary
    this.setData({
      bmid:options.bmid,
      salary:options.salary
    })


    //调用内置的函数getUserInfo来得到当前微信用户的信息，这些信息封装在res里
    wx.getUserInfo({
      //经获得的用户信息传递给setuserinfo方法
      success:this.setuserinfo.bind(this)
    })
  },
  setuserinfo:function(res){
    this.setData({user:res.userInfo})
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
  createorder:function(e){
    //获得表单数据
    var d = e.detail.value;
 
    wx.request({
      url: 'http://localhost:9090/BMProgram_war/bm/createorder',
      data:d,
      success:this.getresult.bind(this)
    })
  },
  getresult:function(res){
    
    wx.showToast({
      title: res.data.msg,
      duration:3000
    });
    //设置定时器：4秒后回到列表页面
    setTimeout(function(){
      wx.navigateBack({
        delta:2
      })
    },4000)
  }
})