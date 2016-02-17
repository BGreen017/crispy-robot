function ret = UAV_path(map)
    % Sample Path 
    [Botx,Boty] = find(map == 60);
    Start = [Botx,Boty];
    [Botx,Boty] = find(map == 30);
    End = [Botx,Boty];
    
   % while (map(Botx,Boty) ~= 30)
       Bot = Start;
       Direction = End - Start;
       
        
        
        % loop test 1
%         if(Bot(1) == 2)
%             Bot(1) = Bot(1) + 1;
%         else
%             [Botx,Boty] = find(map == 30);
%         end
%         
%     end
    
    ret = Direction;
end
