# PagerSlidingTabStrip
###
一款自定义的PagerSlidingTabStrip，修改PagerSlidingTabStrip的源码，让它在标题栏标签文字和标签图片都能正常显示
###
在GitHub上找的PagerSlidingTabStrip虽然功能也很强大，但是他只能让Title的部分要么显示文字，要么显示图片，虽然有回调接口，但是也只支持Title部分全部替换为图片，所以我索性将源码修改，让他在Title的部分文字和图片兼容都能同时显示

![image](https://github.com/AndyRenJie/PagerSlidingTabStrip/blob/master/image/20180630.gif)
 
```
<com.rocky.andy.library.RJPagerSlidingTabStrip
        android:id="@+id/tab_title"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:background="#393f4f"
        app:pstsIndicatorColor="@color/colorAccent"
        app:pstsTextColor="@color/title_style"
        app:pstsImageIndex="3">
    </com.rocky.andy.library.RJPagerSlidingTabStrip>
```
 
###
pstsIndicatorColor：指示器的颜色
### 
pstsTextColor：文字颜色，这里用了一个自定义的color文件
###
pstsImageIndex：这个属性就是自定义的，图片显示在第几个位置

###
然后就在自定义的PagerSlidingTabStrip中添加自己的回调接口

```
public interface ImageTabListener {
        int getPageImageResId();
    }
```

###
在notifyDataSetChanged方法中添加图片方法
 
```
if(i == tabImageIndex){
                    addImageTab(i, ((ImageTabListener) pager.getAdapter()).getPageImageResId());
                }else{
                    addTextTab(i, pager.getAdapter().getPageTitle(i).toString());
                }
```

###
在适配器中实现ImageTabListener

```
@Override
    public int getPageImageResId() {
        return R.mipmap.ic_launcher;
    }
```

###
这样就可以让文字和图片一起显示在Title位置，至于是否需要切换图片样式，就看各自的项目需求
